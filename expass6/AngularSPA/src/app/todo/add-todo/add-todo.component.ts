import {Component} from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {TodoService} from "../todo.service";

@Component({
  selector: 'app-add-todo',
  templateUrl: './add-todo.component.html',
  styleUrls: ['./add-todo.component.css']
})
export class AddTodoComponent {

  addForm = this.formBuilder.group({summary: "", description: ""});

  constructor(
    private service: TodoService,
    private formBuilder: FormBuilder,
  ) {
  }

  onSubmit(): void {
    let info = this.addForm.value;
    this.service.addTodo({
      id: undefined,
      summary: info.summary != undefined ? info.summary : "",
      description: info.description != undefined ? info.description : ""
    }).subscribe();
    this.addForm.reset();
  }
}
