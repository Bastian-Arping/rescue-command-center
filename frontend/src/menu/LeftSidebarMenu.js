import * as React from 'react';
import {ListItemButton, ListItemIcon, ListItemText, Tooltip} from '@mui/material';
import DashboardIcon from '@mui/icons-material/Dashboard';
import AddAlertIcon from '@mui/icons-material/AddAlert';
import VisibilityIcon from '@mui/icons-material/Visibility';
import MapIcon from '@mui/icons-material/Map';

const handleNewEmergency = () => {
    window.location.href = '/emergency/create';
};

const handleEmergencyOverview = () => {
    window.location.href = '/emergency/overview';
};

const handleDashboard = () => {
    window.location.href = '/dashboard';
};

const handleMap = () => {
    window.location.href = '/map';
};

export const mainListItems = (
    <React.Fragment>
        <Tooltip title="Dashboard">
        <ListItemButton onClick={handleDashboard}>
            <ListItemIcon>
                <DashboardIcon />
            </ListItemIcon>
            <ListItemText primary="Dashboard" />
        </ListItemButton>
        </Tooltip>
        <Tooltip title="Neuer Notruf">
        <ListItemButton onClick={handleNewEmergency}>
            <ListItemIcon>
                <AddAlertIcon />
            </ListItemIcon>
            <ListItemText primary="Neuer Notruf" />
        </ListItemButton>
        </Tooltip>
        <Tooltip title="Einsatzübersicht">
            <ListItemButton onClick={handleEmergencyOverview}>
                <ListItemIcon>
                    <VisibilityIcon />
                </ListItemIcon>
                <ListItemText primary="Einsatzübersicht" />
            </ListItemButton>
        </Tooltip>
        <Tooltip title="Karte">
            <ListItemButton onClick={handleMap}>
                <ListItemIcon>
                    <MapIcon />
                </ListItemIcon>
                <ListItemText primary="Karte" />
            </ListItemButton>
        </Tooltip>
    </React.Fragment>
);