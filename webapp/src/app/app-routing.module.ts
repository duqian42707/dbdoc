import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {GenerateComponent} from "./pages/generate/generate.component";

const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: '/generate'},
  {path: 'generate', component: GenerateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
