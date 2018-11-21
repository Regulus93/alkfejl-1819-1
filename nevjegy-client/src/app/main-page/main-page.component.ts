import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  constructor() { 

    this.greetings = [
      'Jó reggelt!',
      'Good morning!',
      'Guten tag!',
      'Buenos dias!'
  ];

  }

  private greetings: string[];

  ngOnInit() {
  }

}
