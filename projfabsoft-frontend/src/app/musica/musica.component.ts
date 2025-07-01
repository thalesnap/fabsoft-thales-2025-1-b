import { Component, ElementRef, ViewChild } from '@angular/core';
import { Musica } from '../model/musica';
import { MusicaService } from '../service/musica.service';
import { Router } from '@angular/router';
import * as bootstrap from 'bootstrap';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-musica',
  templateUrl: './musica.component.html',
  imports: [HttpClientModule, CommonModule],
  styleUrl: './musica.component.css',
  providers: [MusicaService, Router]
})
export class MusicaComponent {
  listaMusicas: Musica[] = [];

  constructor(private musicaService: MusicaService, private router: Router) {}

  ngOnInit() {
    this.musicaService.getMusicas().subscribe(musicas => {
      this.listaMusicas = musicas;
    });
  }

  novo() {
    this.router.navigate(['musicas/novo']);
  }

  alterar(musica: Musica) {
    this.router.navigate(['musicas/alterar', musica.id]);
  }

  abrirConfirmacao(musica: Musica) {
    this.musicaSelecionada = musica;
    this.modal = new bootstrap.Modal(this.modalElement.nativeElement);
    this.modal.show();
  }

  fecharConfirmacao() {
    this.modal.hide();
  }

  confirmarExclusao() {
    this.musicaService.excluirMusica(this.musicaSelecionada.id).subscribe(() => {
      this.fecharConfirmacao();
      this.musicaService.getMusicas().subscribe(musicas => {
        this.listaMusicas = musicas;
      });
    });
  }

ouvir(musica: Musica) {
  const audioUrl = 'data:audio/mp3;base64,' + musica.mp3Data;
  window.open(audioUrl);
}

  @ViewChild('myModal') modalElement!: ElementRef;
  private modal!: bootstrap.Modal;
  private musicaSelecionada!: Musica;
}