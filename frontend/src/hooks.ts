import { createSignal } from "solid-js";

type TodoFormType = {
  id: string | undefined;
  title: string;
  content: string;
  fileName?: string;
};

export const createTodoState = () => {
  const initialValue: TodoFormType = {
    id: undefined,
    title: "",
    content: "",
    fileName: "",
  };
  const [formValue, setFormValue] = createSignal<TodoFormType>(initialValue);

  // fetch

  const createTodo = () => {
    console.log(`create ${formValue}`);
  };

  const updateTodo = () => {
    if (!formValue().id) return;
    console.log(`update ${formValue}`);
  };

  const deleteTodo = () => {
    console.log(`delete ${formValue}`);
  };

  return {
    formValue,
    setFormValue,
    createTodo,
    updateTodo,
    deleteTodo,
  };
};
