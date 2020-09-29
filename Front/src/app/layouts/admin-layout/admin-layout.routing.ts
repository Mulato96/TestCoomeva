import { Routes } from '@angular/router';

import { DashboardComponent } from '../../dashboard/dashboard.component';
import { ConsultarProductosComponent } from '../../consultar-productos/consultar-productos.component';
import { ConsultarVentaComponent } from '../../consultar-venta/consultar-venta.component';
import { RealizarVentaComponent } from '../../realizar-venta/realizar-venta.component';
import { ConsultarClientesComponent } from '../../consultar-clientes/consultar-clientes.component';
import { MapsComponent } from '../../maps/maps.component';
import { NotificationsComponent } from '../../notifications/notifications.component';
import { UpgradeComponent } from '../../upgrade/upgrade.component';

export const AdminLayoutRoutes: Routes = [

    { path: 'dashboard', component: DashboardComponent },
    { path: 'consultar-producto', component: ConsultarProductosComponent },
    { path: 'consultar-venta', component: ConsultarVentaComponent },
    { path: 'realizar-venta', component: RealizarVentaComponent },
    { path: 'consultar-clientes', component: ConsultarClientesComponent },
    { path: 'maps', component: MapsComponent },
    { path: 'notifications', component: NotificationsComponent },
    { path: 'upgrade', component: UpgradeComponent },
];
