import { Component } from '@angular/core';
import { Musica } from '../model/musica';
import { MusicaService } from '../service/musica.service';
import { Router, ActivatedRoute } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-form-musica',
  imports: [HttpClientModule, CommonModule, FormsModule],
  templateUrl: './form-musica.component.html',
  styleUrl: './form-musica.component.css',
  providers: [MusicaService, Router]
})
export class FormMusicaComponent {
  musica: Musica = new Musica();

  constructor(
    private musicaService: MusicaService,
    private router: Router,
    private activeRouter: ActivatedRoute
  ) {
    const id = this.activeRouter.snapshot.paramMap.get('id');
    if (id) {
      this.musicaService.getMusicaById(+id).subscribe(m => {
        this.musica = m;
      });
    }
  }

salvar() {
  if (!this.musica.id && this.activeRouter.snapshot.paramMap.get('id')) {
    this.musica.id = +this.activeRouter.snapshot.paramMap.get('id')!;
  }
  const musicaPayload = {
    id: this.musica.id,
    nome: this.musica.nome,
    urlArquivo: this.musica.urlArquivo
  };
  this.musicaService.saveMusica(musicaPayload).subscribe({
    next: () => this.router.navigate(['musicas']),
    error: (err) => {
      console.error('Erro ao salvar música:', err);
      alert('Falha ao salvar a música.');
    }
  });
}}