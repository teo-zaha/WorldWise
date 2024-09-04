import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Quiz } from '../models/quiz';
import { Question } from '../models/question';

@Injectable()
export class QuizService {

  private apiUrl = 'http://localhost:8080/api/quizzes';

  constructor(private http: HttpClient) { }

  getQuizes(): Observable<Quiz[]> {
    return this.http.get<Quiz[]>(this.apiUrl);
  }

  getQuiz(name: string): Observable<Quiz> {
    return this.http.get<Quiz>(`${this.apiUrl}/${name}`);
  }

  getQuestions(name: string): Observable<Question[]> {
    return this.http.get<Question[]>(`${this.apiUrl}/${name}/questions`);
  }

}