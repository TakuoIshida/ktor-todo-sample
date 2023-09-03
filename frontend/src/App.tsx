import { createSignal, type Component } from "solid-js";
import AppHeader from "./AppHeader";
import TodoPage from "./TodoPage";
import { Button } from "@suid/material";
import { TodoListItem } from "./domain/todo/entity/model";

const App: Component = () => {
  const [text, setText] = createSignal("");

  const handleTextChangeClick = (value: string) => {
    setText(value);
  };
  // 追加ボタン // テーブル（鉛筆、タイトル、内容、ファイル名、ゴミ箱）
  const todos: TodoListItem[] = [
    {
      id: "1",
      title: "title",
      content: "content",
      fileName: "file",
    },
    {
      id: "2",
      title: "title2",
      content: "content2",
      fileName: "file",
    },
  ];
  return (
    <>
      <AppHeader />
      <h1>TODO 一覧</h1>
      <Button variant="outlined">新しいTODOを追加</Button>
      <TodoPage
        text={"gewoih"}
        onChange={() => {
          console.log("hoergie");
        }}
        todos={todos}
      />
    </>
  );
};

export default App;

// routing
// useParam
// fetch => loader
