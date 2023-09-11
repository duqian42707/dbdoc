import {Component} from '@angular/core';
import {HttpClient, HttpEvent, HttpResponse} from "@angular/common/http";
import {downloadFromResponse} from "../../utils/http-download";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-generate',
  templateUrl: './generate.component.html',
  styleUrls: ['./generate.component.less']
})
export class GenerateComponent {

  loading = false;
  validateForm: FormGroup;

  constructor(private http: HttpClient, private fb: FormBuilder) {
    this.validateForm = this.fb.group({
      dbUrl: [null, [Validators.required]],
      dbUsername: [null, [Validators.required]],
      dbPassword: [null, [Validators.required]],
      dbSchema: [null],
      fileType: ['HTML',],
      version: ['1.0.0',],
      description: ['数据库表结构文档',]
    })
  }


  submit() {
    const config = this.validateForm.getRawValue();
    const data = new FormData();
    data.set('json', JSON.stringify(config))
    this.loading = true;
    this.http.post('/api/generate', data, {responseType: 'blob', observe: 'events'}).subscribe({
      next: (resp: HttpEvent<Blob>) => {
        if (resp instanceof HttpResponse) {
          this.loading = false;
          downloadFromResponse(resp);
        }
      },
      error: error => {
        this.loading = false;
      }
    })
  }
}
