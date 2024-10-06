import {createAsyncThunk, createSlice} from '@reduxjs/toolkit';
import {get} from "../urlBuilder/GenericHttp";
import {UrlBuilder} from "../urlBuilder/UrlBuilder";

interface PlantDto {
    id: number;
    plant: string;
}

interface PlantsState {
    plants: PlantDto[];
    loading: boolean;
    error: string | null;
}

const initialState: PlantsState = {
    plants: [],
    loading: false,
    error: null,
};

export const fetchPlants = createAsyncThunk('api/plant/fetchPlants', async () => {
    return get<PlantDto[]>(new UrlBuilder().path("api").path("plant").path("all").build());
});

const plantsSlice = createSlice({
    name: 'plants',
    initialState,
    reducers: {},
    extraReducers: (builder) => {
        builder
            .addCase(fetchPlants.pending, (state) => {
                state.loading = true;
                state.error = null;
            })
            .addCase(fetchPlants.fulfilled, (state, action) => {
                state.plants = action.payload;
                state.loading = false;
            })
            .addCase(fetchPlants.rejected, (state, action) => {
                state.loading = false;
                state.error = action.error.message || 'Failed to fetch model years';
            });
    },
});

export default plantsSlice.reducer;
