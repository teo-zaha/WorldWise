import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-german-states',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './german-states.component.html',
  styleUrls: ['./german-states.component.css']
})
export class GermanStatesComponent {
  public prompt = "prompt";
  public answer = "label";
  public title = "quiz-title";
}