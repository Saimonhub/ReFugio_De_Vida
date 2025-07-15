    package com.simon.refugiodevida.Crud.model;


    import jakarta.persistence.*;
    import java.time.LocalDateTime;

    @Entity
    @Table(name = "entrada_emocional")
    public class EntradaEmocional {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private LocalDateTime fecha;

        private String emocion;

        @Column(length = 1000)
        private String descripcion;

        // Constructores, getters y setters

        public EntradaEmocional() {
            this.fecha = LocalDateTime.now();
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public LocalDateTime getFecha() {
            return fecha;
        }

        public void setFecha(LocalDateTime fecha) {
            this.fecha = fecha;
        }

        public String getEmocion() {
            return emocion;
        }

        public void setEmocion(String emocion) {
            this.emocion = emocion;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }
    }

