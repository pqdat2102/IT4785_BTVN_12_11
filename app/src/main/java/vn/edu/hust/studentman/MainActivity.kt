package vn.edu.hust.studentman

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import vn.edu.hust.studentman.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
  var instance: MainActivity? = null
  lateinit var listStudent: MutableList<StudentModel>
  lateinit var studentAdap: StudentAdapter
  var binding: ActivityMainBinding? = null
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    instance = this
    val students = mutableListOf(
      StudentModel("Nguyễn Văn An", "SV001"),
      StudentModel("Trần Thị Bảo", "SV002"),
      StudentModel("Lê Hoàng Cường", "SV003"),
      StudentModel("Phạm Thị Dung", "SV004"),
      StudentModel("Đỗ Minh Đức", "SV005"),
      StudentModel("Vũ Thị Hoa", "SV006"),
      StudentModel("Hoàng Văn Hải", "SV007"),
      StudentModel("Bùi Thị Hạnh", "SV008"),
      StudentModel("Đinh Văn Hùng", "SV009"),
      StudentModel("Nguyễn Thị Linh", "SV010"),
      StudentModel("Phạm Văn Long", "SV011"),
      StudentModel("Trần Thị Mai", "SV012"),
      StudentModel("Lê Thị Ngọc", "SV013"),
      StudentModel("Vũ Văn Nam", "SV014"),
      StudentModel("Hoàng Thị Phương", "SV015"),
      StudentModel("Đỗ Văn Quân", "SV016"),
      StudentModel("Nguyễn Thị Thu", "SV017"),
      StudentModel("Trần Văn Tài", "SV018"),
      StudentModel("Phạm Thị Tuyết", "SV019"),
      StudentModel("Lê Văn Vũ", "SV020")
    )
    listStudent = students
    val studentAdapter = StudentAdapter(this, students)

    findViewById<RecyclerView>(R.id.recycler_view_students).run {
      adapter = studentAdapter
      layoutManager = LinearLayoutManager(this@MainActivity)
    }
    studentAdap = studentAdapter
    findViewById<Button>(R.id.btn_add_new).setOnClickListener {
      showAddStudentDialog()
    }
  }
  fun showAddStudentDialog() {
    val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_add_student, null)
    val builder = AlertDialog.Builder(this)
    builder.setView(dialogView)
      .setTitle("Thêm thông tin sinh viên")
      .setPositiveButton("Thêm") { dialog, _ ->
        val name = dialogView.findViewById<EditText>(R.id.etName).text.toString()
        val id = dialogView.findViewById<EditText>(R.id.etId).text.toString()
        listStudent.add(StudentModel(name, id))
        studentAdap.notifyDataSetChanged()
        dialog.dismiss()
      }
      .setNegativeButton("Hủy") { dialog, _ ->
        dialog.dismiss()
      }
      .create()
      .show()
  }
  fun showEditStudentDialog(student: StudentModel) {
    val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_add_student, null)
    dialogView.findViewById<EditText>(R.id.etName).setText(student.studentName)
    dialogView.findViewById<EditText>(R.id.etId).setText(student.studentId)

    val builder = AlertDialog.Builder(this)
    builder.setView(dialogView)
      .setTitle("Chỉnh sửa thông tin sinh viên")
      .setPositiveButton("Lưu") { dialog, _ ->
        val index = listStudent.indexOf(student)
        val updatedName = dialogView.findViewById<EditText>(R.id.etName).text.toString()
        val updatedId = dialogView.findViewById<EditText>(R.id.etId).text.toString()
        updateStudent(index, StudentModel(updatedName, updatedId))
        dialog.dismiss()
      }
      .setNegativeButton("Hủy") { dialog, _ ->
        dialog.dismiss()
      }
      .create()
      .show()
  }
  fun updateStudent(index: Int, student: StudentModel){
    listStudent.set(index, student)
    studentAdap.notifyDataSetChanged()
  }
  fun showDeleteConfirmation(student: StudentModel) {
    AlertDialog.Builder(this)
      .setTitle("Xóa thông tin sinh viên")
      .setMessage("Xác nhận xoá thông tin sinh viên: ${student.studentName}?")
      .setPositiveButton("Xoá") { dialog, _ ->
        listStudent.remove(student)
        studentAdap.notifyDataSetChanged()
        showUndoSnackbar(student)
        dialog.dismiss()
      }
      .setNegativeButton("Không") { dialog, _ ->
        dialog.dismiss()
      }
      .create()
      .show()
  }
  fun showUndoSnackbar(deletedStudent: StudentModel) {
    Snackbar.make(findViewById(R.id.main), "${deletedStudent.studentName} đã được xóa", Snackbar.LENGTH_LONG)
      .setAction("Hoàn tác") {
        listStudent.add(deletedStudent)
        listStudent.sortBy { it.studentId }
        studentAdap.notifyDataSetChanged()
      }
      .show()
  }



}