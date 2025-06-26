import { Component, ViewChild, ElementRef } from '@angular/core';
import { CommonModule } from '@angular/common';

interface Musica {
  titulo: string;
  artista: string;
  album: string;
  urlAudio: string;
}

@Component({
  selector: 'app-player',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './player.component.html',
  styleUrl: './player.component.css'
})
export class PlayerComponent {
  musicas: Musica[] = [
    {
      titulo: 'One',
      artista: 'Metallica',
      album: 'And Justice For All',
      urlAudio: 'assets/Metallica-One.mp3'
    },
    {
      titulo: 'Breed',
      artista: 'Nirvana',
      album: 'Nevermind',
      urlAudio: 'assets/Nirvana-Breed.mp3'
    },
    {
      titulo: 'Time to Pretend',
      artista: 'MGMT',
      album: 'Oracular Spectacular',
      urlAudio: 'assets/TimeToPretend.mp3'
    },
      {
      titulo: 'Breed',
      artista: 'Nirvana',
      album: 'Nevermind',
      urlAudio: 'assets/'
    },
  ];

  
  musicaTocando: Musica = this.musicas[0];

  @ViewChild('audioPlayer') audioPlayer!: ElementRef<HTMLAudioElement>;

  tocar(musica: Musica) {
    this.musicaTocando = musica;
    setTimeout(() => {
      this.audioPlayer?.nativeElement.load();
      this.audioPlayer?.nativeElement.play();
    }, 0);
  }
}