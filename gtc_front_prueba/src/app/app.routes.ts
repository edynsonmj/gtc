import { Routes } from '@angular/router';
import { ListaEstudiante } from './lista-estudiante/lista-estudiante';
import { FormularioEstudiante } from './formulario-estudiante/formulario-estudiante';

export const routes: Routes = [
    //{path: '', redirectTo: 'estudiantes', pathMatch: 'full'},
    {path: '', component: ListaEstudiante},
    {path: 'estudiantes', component: ListaEstudiante},
    {path: 'agregar-estudiante', component:FormularioEstudiante}
];
