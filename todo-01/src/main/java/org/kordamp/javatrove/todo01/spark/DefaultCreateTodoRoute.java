/*
 * Copyright 2016-2017 Andres Almiray
 *
 * This file is part of Java Trove Examples
 *
 * Java Trove Examples is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Java Trove Examples is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Java Trove Examples. If not, see <http://www.gnu.org/licenses/>.
 */
package org.kordamp.javatrove.todo01.spark;

import org.kordamp.javatrove.todo01.model.Todo;
import org.kordamp.javatrove.todo01.routes.CreateTodoRoute;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

/**
 * @author Andres Almiray
 */
public class DefaultCreateTodoRoute extends DefaultListTodosRoute implements CreateTodoRoute {
    @Override
    protected ModelAndView doHandle(Request request, Response response) throws Exception {
        String description = request.queryParams("description");
        if (description != null && !description.isEmpty()) {
            todoRepository.save(Todo.builder().description(description).build());
        }
        return super.doHandle(request, response);
    }
}
