import { Component, ViewChild, ElementRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

interface Musica {
  titulo: string;
  artista: string;
  album: string;
  urlAudio: string;
}

@Component({
  selector: 'app-player',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './player.component.html',
  styleUrl: './player.component.css'
})
export class PlayerComponent {
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
    },

  ];

  
  musicaTocando: Musica = this.musicas[0];
  searchTerm: string = '';

  @ViewChild('audioPlayer') audioPlayer!: ElementRef<HTMLAudioElement>;

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
    setTimeout(() => {
      this.audioPlayer?.nativeElement.load();
      this.audioPlayer?.nativeElement.play();
    }, 0);
  }
    likedSongs: Musica[] = [];
    menuAberto: Musica | null = null;

  toggleMenu(musica: Musica, event: MouseEvent) {
    event.stopPropagation();
    this.menuAberto = this.menuAberto === musica ? null : musica;
  }

  curtirMusica(musica: Musica) {
    if (!this.likedSongs.includes(musica)) {
      this.likedSongs.push(musica);
    }
    this.menuAberto = null;
  }
}