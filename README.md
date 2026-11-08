# Entornos de Desarrollo · DAW1 (0487)

Sitio del módulo profesional **0487 Entornos de Desarrollo** del CFGS Desarrollo de Aplicaciones Web (1.º, modalidad semipresencial, Comunitat Valenciana), generado con [Zensical](https://zensical.org/).

## Estructura

```text
.
├── zensical.toml              # configuración y navegación del sitio
├── docs/
│   ├── index.md               # portada
│   ├── modulo/                # guía: RA y CE, temporización, evaluación, rúbricas, entorno, créditos
│   ├── up1/ … up7/            # unidades de programación (presentación, apuntes y tareas)
│   ├── recursos/              # código de ejemplo y plantillas descargables
│   └── soluciones/            # solo para el docente (borrador: no se publica)
└── .github/workflows/docs.yml # publicación en GitHub Pages
```

| UP | Título | RA | Horas |
|:--:|--------|:--:|:-----:|
| 1 | Desarrollo de software y metodologías ágiles | RA1 | 9 |
| 2 | Entornos de desarrollo integrados | RA2 | 9 |
| 3 | Control de versiones y trabajo colaborativo | RA4 (f, h) | 15 |
| 4 | Diseño y realización de pruebas | RA3 | 21 |
| 5 | Refactorización, documentación e integración continua | RA4 (a–e, g, i) | 15 |
| 6 | Diagramas de clases | RA5 | 15 |
| 7 | Diagramas de comportamiento | RA6 | 12 |

## Trabajar en local

```bash
python -m venv .venv
source .venv/bin/activate        # Windows: .venv\Scripts\activate
pip install zensical
zensical serve                   # http://localhost:8000 (incluye las soluciones en borrador)
zensical build --clean           # genera site/ (sin las soluciones)
```

## Publicar en GitHub Pages

1. Crea el repositorio en GitHub y súbelo (`git remote add origin …` y `git push -u origin main`).
2. En *Settings → Pages → Build and deployment → Source*, elige **GitHub Actions**.
3. Cada *push* a `main` publica el sitio con `.github/workflows/docs.yml`.

## Pendiente de completar

- [ ] `site_url` en `zensical.toml` (usuario u organización de GitHub).
- [ ] Nombre del docente en `zensical.toml` (`site_author`, `copyright`) y en `docs/modulo/index.md` y `docs/modulo/creditos.md`.
- [ ] Fechas del calendario 2026-27 en `docs/modulo/temporizacion.md`.

## Licencia

Contenidos bajo [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/deed.es). Adaptan materiales del curso de Aules 2025-26 de Eva Palomar Sarrió y Vicent Martí (ver `docs/modulo/creditos.md`).
