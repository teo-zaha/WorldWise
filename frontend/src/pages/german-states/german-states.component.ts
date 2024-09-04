import { Component, OnDestroy, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { Quiz } from '../../models/quiz';
import { Question } from '../../models/question';
import { QuizService } from '../../services/quiz-service.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-german-states',
  standalone: true,
  imports: [RouterOutlet, FormsModule, CommonModule],
  templateUrl: './german-states.component.html',
  styleUrls: ['./german-states.component.css']
})
export class GermanStatesComponent implements OnInit, OnDestroy {
  public title = "title";
  public prompt = "prompt";
  public answer = "answer";
  public userAnswer = "";
  public isAnswerCorrect = true;

  quiz: Quiz = new Quiz;
  questions: Question[] = [];
  currentQuestionIndex = 0;

  constructor(private quizService: QuizService) { }

  ngOnInit(): void {
    this.quizService.getQuiz('German states and their capitals').subscribe(quiz => {
      this.quiz = quiz;
      this.title = quiz.name;
      this.answer = quiz.answer;
      this.quizService.getQuestions(quiz.name).subscribe(questions => {
        this.questions = questions;
        this.getNextQuestion();
      });
    });
  }

  ngOnDestroy(): void {
  }

  getNextQuestion(): void {
    if (this.questions.length > 0) {
      const randomIndex = Math.floor(Math.random() * this.questions.length);
      this.prompt = this.questions[randomIndex].prompt;
      this.userAnswer = "";
      this.isAnswerCorrect = true;
      this.questions.splice(randomIndex, 1);
    } else {
      console.log("No more questions!");
    }
  }

  checkAnswer(): void {
    if (this.userAnswer.trim().toLowerCase() === this.questions[this.currentQuestionIndex].answer.trim().toLowerCase()) {
      this.isAnswerCorrect = true;
      this.currentQuestionIndex++;
      this.getNextQuestion();
    } else {
      this.isAnswerCorrect = false;
    }
  }
}