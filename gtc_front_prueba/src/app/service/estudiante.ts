import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EstudianteModelo } from '../models/estudiante';

@Injectable({
  providedIn: 'root',
})
export class Estudiante {
  private apiUrl = "http://localhost:8081/api/estudiante";
  constructor(private http: HttpClient){};

  getEstudiante(): Observable<EstudianteModelo[]>{
    return this.http.get<EstudianteModelo[]>(this.apiUrl);
  }
}
