import {Component, OnInit} from '@angular/core';
import {TodoService} from "./todo.service";
import {Todo} from "../model/Todo";

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {
  todos: Todo[];

  constructor(private service: TodoService) {
    this.todos = [];
  }

  ngOnInit(): void {
    this.showTodos();
  }

  showTodos() {
    this.service.getTodos().subscribe((value: Todo[]) => this.todos = value);
  }

  deleteTodo(id: bigint | undefined){
    if(id == undefined) return;
    this.service.deleteTodo(id).subscribe();
    this.showTodos();
  }
}
