import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import * as http from "http";
import {Todo} from "../model/Todo";

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  constructor(private http: HttpClient) {
  }

  getTodos() {
    return this.http.get<Todo[]>("/todos", {responseType: "json"});
  }

  addTodo(todo: Todo) {
    return this.http.post<any>("/todos", todo);
  }

  deleteTodo(id:bigint){
    return this.http.delete(`/todos/${id}`);
  }
}
