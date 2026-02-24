import { Component, signal } from '@angular/core';
import { EstudianteModelo } from '../models/estudiante';
import { Estudiante } from '../service/estudiante';
import {MatCardModule} from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatListModule} from '@angular/material/list';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-lista-estudiante',
  standalone: true,
  imports: [CommonModule, MatCardModule, MatButtonModule, 
    MatIconModule, MatListModule, RouterModule],
  templateUrl: './lista-estudiante.html',
  styleUrl: './lista-estudiante.css',
})
export class ListaEstudiante {
  estudiantes = signal<EstudianteModelo[]>([]);
  errorMessage: string = '';
  
  constructor(private estudianteService: Estudiante){}
  
  ngOnInit(): void {
      this.cargarEstudiantes();
  }

  cargarEstudiantes(): void{
    this.estudianteService.getEstudiante().subscribe({
      next: (data)=>{
        this.estudiantes.set(data);
        console.log(data);
      },
      error:(err)=>{
        this.errorMessage = 'Error al cargar estudiantes:'+err.message;
        console.log(err);
      }
    });

  }
}
