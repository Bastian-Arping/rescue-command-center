import {Box, Container, Grid, Toolbar} from '@mui/material';

import {createTheme, ThemeProvider} from "@mui/material/styles";

import * as React from "react";

import Copyright from '../functions/Copyright'
import MenuBar from "../menu/MenuBar";
import {useNavigate} from "react-router-dom";
import {getTokenData} from "../functions/getTokenData";

const defaultTheme = createTheme();

export default function AdminRolemanagement() {
    const navigate = useNavigate();

    const { isAdmin } = getTokenData();

    if(!isAdmin){
        navigate('/settings/dashboard');
    }

    return (
        <ThemeProvider theme={defaultTheme}>
            <Box sx={{ display: 'flex' }}>
                <MenuBar title="Rollenverwaltung"/>
                <Box
                    component="main"
                    sx={{
                        backgroundColor: (theme) =>
                            theme.palette.mode === 'light'
                                ? theme.palette.grey[100]
                                : theme.palette.grey[900],
                        flexGrow: 1,
                        height: '100vh',
                        overflow: 'auto',
                    }}
                >
                    <Toolbar />
                    <Container maxWidth="lg" sx={{ mt: 4, mb: 4 }}>
                        <Grid container spacing={3}>

                        </Grid>
                        <Copyright sx={{ pt: 4 }} />
                    </Container>
                </Box>
            </Box>
        </ThemeProvider>
    );
}