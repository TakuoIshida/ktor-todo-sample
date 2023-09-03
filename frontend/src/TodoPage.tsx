import { createSignal, type Component, createMemo, mapArray } from "solid-js";
import { TodoListItem } from "./domain/todo/entity/model";
import {
  Paper,
  SvgIcon,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Icon,
  Button,
} from "@suid/material";

type TodoPageProps = {
  text: string;
  onChange: (value: string) => void;
  todos: TodoListItem[];
};

const TodoPage: Component<TodoPageProps> = (props) => {
  return (
    <>
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 650 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell align="center"></TableCell>
              <TableCell align="center">タイトル</TableCell>
              <TableCell align="left">内容</TableCell>
              <TableCell align="left">ファイル名</TableCell>
              <TableCell align="left"></TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {props.todos.map((row) => (
              <TableRow>
                <TableCell align="center">
                  <Button variant="contained">編集</Button>
                </TableCell>
                <TableCell align="center">{row.title}</TableCell>
                <TableCell align="left">{row.content}</TableCell>
                <TableCell align="left">{row.fileName ?? ""}</TableCell>
                <TableCell>
                  <Button variant="contained">削除</Button>
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </>
  );
};

export default TodoPage;
