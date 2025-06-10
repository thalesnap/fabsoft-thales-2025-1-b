import { Routes } from '@angular/router';
import { UsuarioComponent } from './usuario/usuario.component';
import { FormUsuarioComponent } from './form-usuario/form-usuario.component';


export const routes: Routes = [
    { path: 'usarios', component: UsuarioComponent},
    { path: 'usarios/novo', component: FormUsuarioComponent},
];