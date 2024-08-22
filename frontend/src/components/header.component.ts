import { Component } from '@angular/core';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [],
  template: `
    <header>
      <div class="container">
        <img src="logo.png" alt="WorldWise">
      </div>
    </header>
  `,
  styles: [`
    header {
      background-color: #a1d278;
      padding: 0;
      margin: 0;
    }
    header img {
      width: 175px;
      padding-top: 15px;
      padding-bottom: 10px;
      padding-left: 15px;
    }
  `]
})
export class HeaderComponent {}