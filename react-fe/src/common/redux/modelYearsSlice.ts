import {createAsyncThunk, createSlice} from '@reduxjs/toolkit';
import {get} from "../urlBuilder/GenericHttp";
import {UrlBuilder} from "../urlBuilder/UrlBuilder";

interface ModelYearDto {
    modelYearIdentificationLetter: string;
    year: number;
}

interface ModelYearsState {
    modelYears: ModelYearDto[];
    loading: boolean;
    error: string | null;
}

const initialState: ModelYearsState = {
    modelYears: [],
    loading: false,
    error: null,
};

export const fetchModelYears = createAsyncThunk('api/modelYears/fetchModelYears', async () => {
    return get<ModelYearDto[]>(new UrlBuilder().path("api").path("modelyear").path("all").build());
});

const modelYearsSlice = createSlice({
    name: 'modelYears',
    initialState,
    reducers: {},
    extraReducers: (builder) => {
        builder
            .addCase(fetchModelYears.pending, (state) => {
                state.loading = true;
                state.error = null;
            })
            .addCase(fetchModelYears.fulfilled, (state, action) => {
                state.modelYears = action.payload;
                state.loading = false;
            })
            .addCase(fetchModelYears.rejected, (state, action) => {
                state.loading = false;
                state.error = action.error.message || 'Failed to fetch model years';
            });
    },
});

export default modelYearsSlice.reducer;
