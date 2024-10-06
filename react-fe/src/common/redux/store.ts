import {configureStore} from '@reduxjs/toolkit';
import modelYearsReducer from './modelYearsSlice';
import manufacturersReducer from './manufacturersSlice';
import marketsReducer from './marketsSlice';
import plantsReducer from './plantsSlice';
import userDataReducer from './userDataSlice';

export const store = configureStore({
    reducer: {
        modelYears: modelYearsReducer,
        manufacturers: manufacturersReducer,
        markets: marketsReducer,
        plants: plantsReducer,
        userData: userDataReducer,
    },
});

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;
