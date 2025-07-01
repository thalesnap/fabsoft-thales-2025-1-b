import { Component } from '@angular/core';
import { Usuario } from '../model/usuario';
import { UsuarioService } from '../service/usuario.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-form-usuario',
  imports: [HttpClientModule, CommonModule, FormsModule],
  templateUrl: './form-usuario.component.html',
  styleUrl: './form-usuario.component.css',
  providers: [UsuarioService, Router]
})
export class FormUsuarioComponent {
  usuario: Usuario = new Usuario();

  constructor(
    private usuarioService: UsuarioService,
    private router: Router,
    private activeRouter: ActivatedRoute
  ) {
    const id = this.activeRouter.snapshot.paramMap.get('id');
    if (id) {
      this.usuarioService.getUsuarioById(id).subscribe(usuario => {
        this.usuario = usuario;
      });
    }
  }

  salvar() {
    this.usuarioService.saveUsuario(this.usuario).subscribe(
      (resultado: any) => {
        localStorage.setItem('currentUserId', resultado.id?.toString() || '');
        // Forçar reinicialização do roteador
        this.router.navigate(['/usuarios']).then(() => {
          console.log('Redirecionado para /player após cadastro');
          // Forçar recarregamento da rota
          this.router.navigated = false;
          this.router.navigate(['/usuarios']);
        }).catch(err => {
          console.error('Erro na navegação:', err);
        });
      },
      error => console.error('Erro ao salvar usuário:', error)
    );
  }
}