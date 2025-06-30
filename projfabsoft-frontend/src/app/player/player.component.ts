import { Component, ViewChild, ElementRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { MusicService } from '../music.service';

interface Musica {
  titulo: string;
  artista: string;
  album: string;
  urlAudio: string;
}

@Component({
  selector: 'app-player',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './player.component.html',
  styleUrl: './player.component.css'
})
export class PlayerComponent {
  musicaTocando: Musica | null = null;

  @ViewChild('audioPlayer') audioPlayer!: ElementRef<HTMLAudioElement>;

  constructor(private musicService: MusicService) {
    this.musicService.musicaTocando$.subscribe(musica => {
      this.musicaTocando = musica;
      if (musica && this.audioPlayer) {
        setTimeout(() => {
          this.audioPlayer.nativeElement.load();
          this.audioPlayer.nativeElement.play();
        }, 0);
      }
    });
  }
}