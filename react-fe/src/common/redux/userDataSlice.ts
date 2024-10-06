import {createAsyncThunk, createSlice} from '@reduxjs/toolkit';
import {get} from "../urlBuilder/GenericHttp";
import {UrlBuilder} from "../urlBuilder/UrlBuilder";

interface UserDataDto {
    id: number;
    name: string;
}

interface UserDataState {
    userData: UserDataDto | null;
    loading: boolean;
    error: string | null;
}

const initialState: UserDataState = {
    userData: null,
    loading: false,
    error: null,
};

export const fetchUserData = createAsyncThunk('api/userdata/fetchUserData', async () => {
    const name = "USER";
    return get<UserDataDto>(new UrlBuilder().path("api").path("userdata").value(name).build());
});

const userDataSlice = createSlice({
    name: 'userData',
    initialState,
    reducers: {},
    extraReducers: (builder) => {
        builder
            .addCase(fetchUserData.pending, (state) => {
                state.loading = true;
                state.error = null;
            })
            .addCase(fetchUserData.fulfilled, (state, action) => {
                state.userData = action.payload;
                state.loading = false;
            })
            .addCase(fetchUserData.rejected, (state, action) => {
                state.loading = false;
                state.error = action.error.message || 'Failed to fetch model years';
            });
    },
});

export default userDataSlice.reducer;
