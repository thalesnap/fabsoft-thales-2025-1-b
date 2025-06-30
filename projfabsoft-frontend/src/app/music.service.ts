import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

interface Musica {
  titulo: string;
  artista: string;
  album: string;
  urlAudio: string;
}

@Injectable({
  providedIn: 'root'
})
export class MusicService {
  private musicaTocandoSubject = new BehaviorSubject<Musica | null>(null);
  musicaTocando$ = this.musicaTocandoSubject.asObservable();

  private likedSongsSubject = new BehaviorSubject<Musica[]>([]);
  likedSongs$ = this.likedSongsSubject.asObservable();

  setMusicaTocando(musica: Musica) {
    this.musicaTocandoSubject.next(musica);
  }

  getLikedSongs(): Musica[] {
    return this.likedSongsSubject.value;
  }

  setLikedSongs(likedSongs: Musica[]) {
    this.likedSongsSubject.next(likedSongs);
  }
}