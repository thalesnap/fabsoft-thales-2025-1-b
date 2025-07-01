import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Musica } from '../model/musica';

@Injectable({ providedIn: 'root' })
export class MusicaService {
  apiURL = 'http://localhost:8080/api/v1/musicas';

  constructor(private http: HttpClient) {}

  getMusicas() {
    return this.http.get<Musica[]>(this.apiURL);
  }

  saveMusica(musica: Musica) {
    if (musica.id) {
      return this.http.put(this.apiURL + '/' + musica.id, musica);
    }
    return this.http.post(this.apiURL, musica);
  }

  getMusicaById(id: any) {
    return this.http.get<Musica>(this.apiURL + '/' + id);
  }

  excluirMusica(id: any) {
    return this.http.delete<Musica>(this.apiURL + '/' + id);
  }
}
