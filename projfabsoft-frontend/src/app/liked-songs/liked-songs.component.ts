import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PlayerComponent } from '../player/player.component';

@Component({
  selector: 'app-liked-songs',
  standalone: true,
  imports: [CommonModule],
  template: `
    <h2>Liked Songs</h2>
    <table>
      <thead>
        <tr>
          <th>Song Name</th>
          <th>Artist Name</th>
          <th>Genre</th>
        </tr>
      </thead>
      <tbody>
        <tr *ngFor="let musica of player.likedSongs">
          <td>{{ musica.titulo }}</td>
          <td>{{ musica.artista }}</td>
          <td>{{ musica.album }}</td>
        </tr>
      </tbody>
    </table>
  `
})
export class LikedSongsComponent {
  player = inject(PlayerComponent);
}