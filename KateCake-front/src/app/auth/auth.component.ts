import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {DataStorageService} from '../shared/data-storage.service';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.less']
})
export class AuthComponent implements OnInit {
  signInForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private dataStorage: DataStorageService) {
  }

  // tslint:disable-next-line:typedef
  ngOnInit() {
    this.signInForm = new FormGroup({
        login: new FormControl(null, [Validators.required]),
        password: new FormControl(null, [Validators.required]),
      }
    );
  }

  // tslint:disable-next-line:typedef
  async signIn() {
    const login = this.signInForm.get('login').value;
    const password = this.signInForm.get('password').value;

    const response = await this.dataStorage.fetchLogin({login, password});

    if (response.token) {
      localStorage.setItem('token', response.token);
      await this.router.navigate(['/home']);
    }
  }

}
