package com.techprd.demo.contollers

import com.techprd.model.Task
import com.techprd.utils.Utils.randomId
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class TaskController {

    var db: HashMap<String, Task> = HashMap()

    init {
        arrayOf("Kotlin is Awesome!", "Buy Milk", "Check Post office", "Call John").forEach {
            val id = randomId()
            db[id] = Task(id, it)
        }
    }

    @GetMapping("/tasks")
    fun getAllTasks(): List<Task> {
        return db.values.toList()
    }

    @GetMapping("/task/{id}")
    fun getTask(
            @PathVariable("id") id: String
    ): Task? {
        return db[id]
    }

    @PostMapping("/task/{id}")
    fun updateTask(
            @PathVariable("id") id: String,
            @RequestBody task: Task

    ): Task? {

        db[id] = task
        return task
    }

}
