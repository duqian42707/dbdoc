import {Component} from '@angular/core';
import {HttpClient, HttpEvent, HttpRequest, HttpResponse} from "@angular/common/http";
import {downloadFromResponse} from "../../utils/http-download";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {NzUploadFile} from "ng-zorro-antd/upload";
import {filter} from "rxjs";

@Component({
  selector: 'app-generate',
  templateUrl: './generate.component.html',
  styleUrls: ['./generate.component.less']
})
export class GenerateComponent {
  fileList: NzUploadFile[] = [];

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


  beforeUpload = (file: NzUploadFile): boolean => {
    this.fileList = [file];
    return false;
  };

  submit() {
    const config = this.validateForm.getRawValue();
    const data = new FormData();
    data.append('json', JSON.stringify(config))
    if (this.fileList.length > 0) {
      data.append('template', this.fileList[0] as any);
    }
    this.loading = true;

    const req = new HttpRequest('POST', '/api/generate', data, {
      reportProgress: true,
      responseType: 'blob',
    });

    this.http
      .request(req)
      .pipe(filter(e => e instanceof HttpResponse))
      .subscribe({
        next: (resp: HttpEvent<unknown>) => {
          this.loading = false;
          downloadFromResponse(resp as any);
        },
        error: error => {
          this.loading = false;
        }
      })
  }
}
