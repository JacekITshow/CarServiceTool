import {createAsyncThunk, createSlice} from '@reduxjs/toolkit';
import {get} from "../urlBuilder/GenericHttp";
import {UrlBuilder} from "../urlBuilder/UrlBuilder";

interface ManufacturerDto {
    id: number;
    manufacturer: string;
}

interface ManufacturersState {
    manufacturers: ManufacturerDto[];
    loading: boolean;
    error: string | null;
}

const initialState: ManufacturersState = {
    manufacturers: [],
    loading: false,
    error: null,
};

export const fetchManufacturers = createAsyncThunk('api/manufacturer/fetchManufacturers', async () => {
    return get<ManufacturerDto[]>(new UrlBuilder().path("api").path("manufacturer").path("all").build());
});

const manufacturersSlice = createSlice({
    name: 'manufacturers',
    initialState,
    reducers: {},
    extraReducers: (builder) => {
        builder
            .addCase(fetchManufacturers.pending, (state) => {
                state.loading = true;
                state.error = null;
            })
            .addCase(fetchManufacturers.fulfilled, (state, action) => {
                state.manufacturers = action.payload;
                state.loading = false;
            })
            .addCase(fetchManufacturers.rejected, (state, action) => {
                state.loading = false;
                state.error = action.error.message || 'Failed to fetch model years';
            });
    },
});

export default manufacturersSlice.reducer;
