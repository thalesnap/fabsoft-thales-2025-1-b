import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
  standalone: true,
  imports: [FormsModule]
})
export class LoginComponent {
  email: string = '';
  senha: string = '';

  constructor(private router: Router) {}

  login() {
    // Aqui você pode implementar a chamada para o backend de autenticação
    // Exemplo: se login for bem-sucedido, redireciona para a home
    if (this.email && this.senha) {
      // Simulação de login
      this.router.navigate(['']);
    } else {
      alert('Preencha todos os campos!');
    }
  }
}