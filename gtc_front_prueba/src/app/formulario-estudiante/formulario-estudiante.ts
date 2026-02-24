import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Estudiante } from '../service/estudiante';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { error } from 'console';

@Component({
  standalone:true,
  selector: 'app-formulario-estudiante',
  imports: [
    CommonModule, 
    ReactiveFormsModule, 
    MatFormFieldModule, 
    MatInputModule, 
    MatButtonModule
  ],
  templateUrl: './formulario-estudiante.html',
  styleUrl: './formulario-estudiante.css',
})
export class FormularioEstudiante {
  private fb = inject(FormBuilder);
  private estudianteService = inject(Estudiante);
  private router = inject(Router);

  estudianteForm: FormGroup = this.fb.group({
    id: ['',[Validators.required]],
    nombre: ['', [Validators.required]],
    apellido: ['', [Validators.required]],
    grupo: [null, [Validators.min(1)]]
  });

  guardarEstudiante(): void {
    if (this.estudianteForm.valid) {
      const nuevoEstudiante = this.estudianteForm.value;
      
      this.estudianteService.postEstudiante(nuevoEstudiante).subscribe({
        next: () => {
          console.log('Estudiante guardado con éxito');
          this.router.navigate(['/estudiantes']);
        },
        
        error: (err) => {
          const errorBackend = err.error; 
  
        
        const mensajeAMostrar = errorBackend?.mensaje || "Error inesperado";

        alert("Error del servidor: " + mensajeAMostrar);
        
        
        console.log('Objeto de error completo:', errorBackend);}
            });
          }
        }

  cancelar(): void {
    this.router.navigate(['/estudiantes']);
  }
}
