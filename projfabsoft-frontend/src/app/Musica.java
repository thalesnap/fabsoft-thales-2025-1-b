import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

interface Musica {
  id: number;
  nome: string;
  artista: { id: number; nome: string };
  urlAudio?: string;
}

interface Artista {
  id: number;
  nome: string;
}

@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.css']
})
export class PlayerComponent implements OnInit {
  musicas: Musica[] = [];
  artistas: Artista[] = [];
  musicaTocando: Musica | null = null;

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.http.get<Musica[]>('http://localhost:8080/api/v1/musicas').subscribe(data => this.musicas = data);
    this.http.get<Artista[]>('http://localhost:8080/api/v1/artistas').subscribe(data => this.artistas = data);
  }

  tocar(musica: Musica) {
    this.musicaTocando = musica;
    // Aqui você pode implementar um player de áudio real se quiser
    alert(`Tocando: ${musica.nome} - ${musica.artista.nome}`);
  }
}import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

interface Musica {
  id: number;
  nome: string;
  artista: { id: number; nome: string };
  urlAudio?: string;
}

interface Artista {
  id: number;
  nome: string;
}

@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.css']
})
export class PlayerComponent implements OnInit {
  musicas: Musica[] = [];
  artistas: Artista[] = [];
  musicaTocando: Musica | null = null;

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.http.get<Musica[]>('http://localhost:8080/api/v1/musicas').subscribe(data => this.musicas = data);
    this.http.get<Artista[]>('http://localhost:8080/api/v1/artistas').subscribe(data => this.artistas = data);
  }

  tocar(musica: Musica) {
    this.musicaTocando = musica;
    // Aqui você pode implementar um player de áudio real se quiser
    alert(`Tocando: ${musica.nome} - ${musica.artista.nome}`);
  }
}