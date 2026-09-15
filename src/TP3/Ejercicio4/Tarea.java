package TP3.Ejercicio4;

public class Tarea {
    private String idTarea;
   private String prioridad;
   private String descripcion;

   public Tarea() {
      this.idTarea = "0";
      this.prioridad = "baja";
      this.descripcion = "default";
   }

   public Tarea(String var1, String var2, String var3) {
      this.idTarea = var1;
      this.prioridad = var2;
      this.descripcion = var3;
   }

   public String getIdTarea() {
      return this.idTarea;
   }

   public void setIdTarea(String var1) {
      this.idTarea = var1;
   }

   public String getPrioridad() {
      return this.prioridad;
   }

   public void setPrioridad(String var1) {
      this.prioridad = var1;
   }

   public String getDescripcion() {
      return this.descripcion;
   }

   public void setDescripcion(String var1) {
      this.descripcion = var1;
   }
}
