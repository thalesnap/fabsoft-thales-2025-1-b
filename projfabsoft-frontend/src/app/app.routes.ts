import { Routes } from '@angular/router';
import { UsuarioComponent } from './usuario/usuario.component';
import { FormUsuarioComponent } from './form-usuario/form-usuario.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { PlayerComponent } from './player/player.component';
import { MusicaComponent } from './musica/musica.component';
import { LikedSongsComponent } from './liked-songs/liked-songs.component';
import { ProfileComponent } from './profile/profile.component';
import { PlayerHomeComponent } from './player-home/player-home.component';

export const routes: Routes = [
  { path: 'musicas', component: MusicaComponent },
  { path: '', component: HomeComponent, pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  {
    path: 'player',
    component: PlayerComponent,
    children: [
      { path: '', component: PlayerHomeComponent }, // /player exibe o PlayerHomeComponent
      { path: 'liked-songs', component: LikedSongsComponent },
      { path: 'profile', component: ProfileComponent }
    ]
  },
  { path: 'usuarios', component: UsuarioComponent },
  { path: 'usuarios/novo', component: FormUsuarioComponent },
  { path: 'usuarios/alterar/:id', component: FormUsuarioComponent },
];