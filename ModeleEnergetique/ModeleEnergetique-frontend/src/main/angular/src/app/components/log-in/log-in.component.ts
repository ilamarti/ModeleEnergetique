import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';


@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent implements OnInit {

  username: string;
  password: string;

  constructor(private router: Router) { }

  ngOnInit(): void {
  }
  
  login() : void {
    alert("login method");
    if(this.username == 'admin' && this.password == 'admin'){
      alert("Valid credentials");
     this.router.navigate(["posts"]);
    }else {
      alert("Invalid credentials");
    }
  }
}

