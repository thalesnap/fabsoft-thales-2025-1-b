import { Routes } from '@angular/router';
import { UsuarioComponent } from './usuario/usuario.component';
import { FormUsuarioComponent } from './form-usuario/form-usuario.component';
import { ArtistaComponent } from './artista/artista.component';
import { FormArtistaComponent } from './form-artista/form-artista.component';
import { GeneroComponent } from './genero/genero.component';
import { FormGeneroComponent } from './form-genero/form-genero.component';
import { MusicaComponent } from './musica/musica.component';
import { FormMusicaComponent } from './form-musica/form-musica.component';
import { PlaylistComponent } from './playlist/playlist.component';
import { FormPlaylistComponent } from './form-playlist/form-playlist.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';


export const routes: Routes = [
    { path: '', component: HomeComponent, pathMatch: 'full' },
    { path: 'login', component: LoginComponent },

    { path: 'usuarios', component: UsuarioComponent},
    { path: 'usuarios/novo', component: FormUsuarioComponent},
    {path: 'usuarios/alterar/:id', component: FormUsuarioComponent},

    { path: 'artistas', component: ArtistaComponent },
    { path: 'artistas/novo', component: FormArtistaComponent },
    { path: 'artistas/alterar/:id', component: FormArtistaComponent },

    { path: 'generos', component: GeneroComponent },
    { path: 'generos/novo', component: FormGeneroComponent },
    { path: 'generos/alterar/:id', component: FormGeneroComponent },

    { path: 'musicas', component: MusicaComponent },
    { path: 'musicas/novo', component: FormMusicaComponent },
    { path: 'musicas/alterar/:id', component: FormMusicaComponent },

    { path: 'playlists', component: PlaylistComponent },
    { path: 'playlists/novo', component: FormPlaylistComponent },
    { path: 'playlists/alterar/:id', component: FormPlaylistComponent }
];