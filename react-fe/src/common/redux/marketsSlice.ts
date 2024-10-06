import {createAsyncThunk, createSlice} from '@reduxjs/toolkit';
import {get} from "../urlBuilder/GenericHttp";
import {UrlBuilder} from "../urlBuilder/UrlBuilder";

interface MarketDto {
    id: number;
    name: string;
}

interface MarketsState {
    markets: MarketDto[];
    loading: boolean;
    error: string | null;
}

const initialState: MarketsState = {
    markets: [],
    loading: false,
    error: null,
};

export const fetchMarkets = createAsyncThunk('api/market/fetchMarkets', async () => {
    return get<MarketDto[]>(new UrlBuilder().path("api").path("market").path("all").build());
});

const marketsSlice = createSlice({
    name: 'markets',
    initialState,
    reducers: {},
    extraReducers: (builder) => {
        builder
            .addCase(fetchMarkets.pending, (state) => {
                state.loading = true;
                state.error = null;
            })
            .addCase(fetchMarkets.fulfilled, (state, action) => {
                state.markets = action.payload;
                state.loading = false;
            })
            .addCase(fetchMarkets.rejected, (state, action) => {
                state.loading = false;
                state.error = action.error.message || 'Failed to fetch model years';
            });
    },
});

export default marketsSlice.reducer;
