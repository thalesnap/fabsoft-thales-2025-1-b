import { Routes } from '@angular/router';
import { UsuarioComponent } from './usuario/usuario.component';
import { FormUsuarioComponent } from './form-usuario/form-usuario.component';
import { ArtistaComponent } from './artista/artista.component';
import { FormArtistaComponent } from './form-artista/form-artista.component';


import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { PlayerComponent } from './player/player.component';
import { LikedSongsComponent } from './liked-songs/liked-songs.component';


export const routes: Routes = [

    { path: 'liked-songs', component: LikedSongsComponent },
    { path: '', component: HomeComponent, pathMatch: 'full' },
    { path: 'login', component: LoginComponent },
    { path: 'player', component: PlayerComponent },

    { path: 'usuarios', component: UsuarioComponent},
    { path: 'usuarios/novo', component: FormUsuarioComponent},
    {path: 'usuarios/alterar/:id', component: FormUsuarioComponent},

    { path: 'artistas', component: ArtistaComponent },
    { path: 'artistas/novo', component: FormArtistaComponent },
    { path: 'artistas/alterar/:id', component: FormArtistaComponent },


];