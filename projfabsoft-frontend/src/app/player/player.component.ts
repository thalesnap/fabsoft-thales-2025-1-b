import { Component } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-player',
  standalone: true,
  imports: [CommonModule, HttpClientModule],
  templateUrl: './player.component.html',
  styleUrl: './player.component.css'
})
export class PlayerComponent {
  musicas: any[] = [];
  artistas: any[] = [];
  musicaTocando: any = null;
  audioPlayer: any;

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.http.get<any[]>('http://localhost:8080/api/v1/musicas').subscribe(data => this.musicas = data);
    this.http.get<any[]>('http://localhost:8080/api/v1/artistas').subscribe(data => this.artistas = data);
  }

  tocar(musica: any) {
    this.musicaTocando = musica;
setTimeout(() => {
      if (this.audioPlayer && this.audioPlayer.nativeElement) {
        this.audioPlayer.nativeElement.load();
        this.audioPlayer.nativeElement.play();
      }
    }, 0);
  }
}