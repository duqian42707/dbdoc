import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {GenerateComponent} from "./generate/generate.component";
import {NzButtonModule} from "ng-zorro-antd/button";
import {NzFormModule} from "ng-zorro-antd/form";
import {ReactiveFormsModule} from "@angular/forms";
import {NzInputModule} from "ng-zorro-antd/input";
import {NzSpinModule} from "ng-zorro-antd/spin";
import {NzRadioModule} from "ng-zorro-antd/radio";
import {NzSelectModule} from "ng-zorro-antd/select";
import {NzUploadModule} from "ng-zorro-antd/upload";


@NgModule({
  declarations: [GenerateComponent],
  imports: [
    CommonModule,
    NzButtonModule,
    NzFormModule,
    ReactiveFormsModule,
    NzInputModule,
    NzSpinModule,
    NzRadioModule,
    NzSelectModule,
    NzUploadModule
  ]
})
export class PagesModule {
}
