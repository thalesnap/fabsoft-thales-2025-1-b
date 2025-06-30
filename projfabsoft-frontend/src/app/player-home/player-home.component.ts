import { Component } from '@angular/core';
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
  selector: 'app-player-home',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './player-home.component.html',
  styleUrl: './player-home.component.css'
})
export class PlayerHomeComponent {
  musicas: Musica[] = [
    {
      titulo: 'Instant Crush',
      artista: 'Daft Punk',
      album: 'Random Access Memories',
      urlAudio: 'assets/DaftPunk-InstantCrush.mp3'
    },
    {
      titulo: 'One',
      artista: 'Metallica',
      album: 'And Justice For All',
      urlAudio: 'assets/Metallica-One.mp3'
    },
    {
      titulo: 'Quase Sem Querer',
      artista: 'Legião Urbana',
      album: 'As Quatro Estações',
      urlAudio: 'assets/QuaseSemQuerer.mp3'
    },
    {
      titulo: 'Time to Pretend',
      artista: 'MGMT',
      album: 'Oracular Spectacular',
      urlAudio: 'assets/TimeToPretend.mp3'
    }
  ];

  musicaTocando: Musica = this.musicas[0];
  searchTerm: string = '';
  likedSongs: Musica[] = [];

  constructor(private musicService: MusicService) {
    this.likedSongs = this.musicService.getLikedSongs();
    this.musicService.musicaTocando$.subscribe(musica => {
      this.musicaTocando = musica || this.musicas[0];
    });
    this.musicService.likedSongs$.subscribe(likedSongs => {
      this.likedSongs = likedSongs;
    });
  }

  get musicasFiltradas() {
    const term = this.searchTerm.trim().toLowerCase();
    if (!term) return this.musicas;
    return this.musicas.filter(m =>
      m.titulo.toLowerCase().includes(term) ||
      m.artista.toLowerCase().includes(term)
    );
  }

  tocar(musica: Musica) {
    this.musicaTocando = musica;
    this.musicService.setMusicaTocando(musica);
  }

  curtirMusica(musica: Musica) {
    if (!this.likedSongs.some(s => s.titulo === musica.titulo && s.artista === musica.artista)) {
      this.likedSongs.push(musica);
      this.musicService.setLikedSongs(this.likedSongs);
    }
  }
}