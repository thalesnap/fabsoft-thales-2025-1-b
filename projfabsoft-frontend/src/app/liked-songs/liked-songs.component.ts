import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MusicService } from '../music.service';

interface Musica {
  titulo: string;
  artista: string;
  album: string;
  urlAudio: string;
}

@Component({
  selector: 'app-liked-songs',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './liked-songs.component.html',
  styleUrl: './liked-songs.component.css'
})
export class LikedSongsComponent implements OnInit {
  likedSongs: Musica[] = [];
  musicaTocando: Musica | null = null;

  constructor(private musicService: MusicService) {}

  ngOnInit() {
    this.likedSongs = this.musicService.getLikedSongs();
    this.musicService.likedSongs$.subscribe(likedSongs => {
      this.likedSongs = likedSongs;
    });
    this.musicService.musicaTocando$.subscribe(musica => {
      this.musicaTocando = musica;
    });
  }

  tocar(musica: Musica) {
    this.musicService.setMusicaTocando(musica);
  }

  descurtirMusica(musica: Musica) {
    const updatedLikedSongs = this.likedSongs.filter(s => s.titulo !== musica.titulo || s.artista !== musica.artista);
    this.musicService.setLikedSongs(updatedLikedSongs);
  }
}